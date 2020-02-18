import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTMergeCell;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTMergeCells;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        int sheetIndex = 0; 
        SXSSFWorkbook sxssfWorkbook = new SXSSFWorkbook(1000);
        SXSSFSheet sheet = sxssfWorkbook.createSheet();
        sxssfWorkbook.setSheetName(sheetIndex, "表1");
        CTWorksheet sheetX = sheet.getWorkbook().getXSSFWorkbook().getSheetAt(sheetIndex).getCTWorksheet();

        CellStyle cellStyle = sxssfWorkbook.createCellStyle();
        // 样式自己定义 ......

        // 宿便输出一些内容
        for (int i = 0; i < 10; i++) {
            List list = new ArrayList<>();
            list.add(new ColspanAndText("姓名001", 2, cellStyle));
            list.add(new ColspanAndText("男", 1, cellStyle));
            list.add(new ColspanAndText("地址", 10, cellStyle));
            // 写入一行数据
            setCellTextForCTWorksheet(sheet, sheetX, 0, i, list, cellStyle);
        }

        // 随便输出到文件或者返回给用户......
    }

    private static void setCellTextForCTWorksheet(SXSSFSheet sheet, CTWorksheet sheetX, int rowIndex, int firstCol, List<ColspanAndText> list, CellStyle style) {
        /**
         *  合并单元格
         */
        int startCol = firstCol;
        CellRangeAddress cellRangeAddress = new CellRangeAddress(rowIndex, rowIndex, startCol, startCol);
        for (ColspanAndText text : list) {
            int cols = text.getColspan();
            // cols > 1 合并单元格，业务控制，cols==1回报错误
            if (cols > 1) {
                cellRangeAddress.setFirstRow(rowIndex);
                cellRangeAddress.setLastRow(rowIndex);
                cellRangeAddress.setFirstColumn(startCol);
                cellRangeAddress.setLastColumn(startCol + cols - 1);
                // 重写合并的方法
                addMergedReigon(sheetX, cellRangeAddress);
            }
            startCol += cols;
        }
    }

    private static void addMergedReigon(CTWorksheet sheetX, CellRangeAddress cellRangeAddress) {
        CTMergeCells ctMergeCells;
        if (sheetX.isSetMergeCells()) {
            ctMergeCells = sheetX.getMergeCells();
        } else {
            ctMergeCells = sheetX.addNewMergeCells();
        }

        CTMergeCell ctMergeCell = ctMergeCells.addNewMergeCell();
        ctMergeCell.setRef(cellRangeAddress.formatAsString());
    }

    private static class ColspanAndText {
        private int colspan;
        private String text;
        private CellStyle cellStyle;

        public ColspanAndText(String text, int colspan, CellStyle cellStyle) {
            this.colspan = colspan;
            this.text = text;
            this.cellStyle = cellStyle;
        }

        public int getColspan() {
            return colspan;
        }

        public void setColspan(int colspan) {
            this.colspan = colspan;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        public void setCellStyle(HSSFCellStyle cellStyle) {
            this.cellStyle = cellStyle;
        }
    }
}
