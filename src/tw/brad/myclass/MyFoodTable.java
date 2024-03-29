package tw.brad.myclass;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class MyFoodTable extends JTable{
	private MyTableModel tableModel;
	private FoodDB foodDB;
	
	public MyFoodTable() throws Exception{//建構式
		
		foodDB = new FoodDB();
		foodDB.queryData("SELECT * FROM food");
		
		tableModel = new MyTableModel();
		setModel(tableModel);
		tableModel.setColumnIdentifiers(foodDB.getHeader());
		
	}
	public void delRow() {
		tableModel.removeRow(getSelectedRow());       
		 repaint();
		 
	}
	public void addRow() {
		tableModel.addRow(new String[2] ); //騙，只要不跟子類別(其他方式)衝突就好了
		repaint();
		scrollRectToVisible(getCellRect(foodDB.getRows()+1, 0, false));
	}
	
	public void newsql() {
		try {
			foodDB.queryData("SELECT id, name, tel FROM food ORDER BY name");
			tableModel.setColumnIdentifiers(foodDB.getHeader());
			//foodDB.queryData("SELECT picul FROM food ORDER BY name");
			
			
			
			repaint();
			
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	
	private class MyTableModel extends DefaultTableModel {

		@Override
		public int getRowCount() {
			return foodDB.getRows();
		}

		@Override
		public int getColumnCount() {
			return foodDB.getCols();
		}

		@Override
		public Object getValueAt(int row, int column) {
			return foodDB.getData(row+1, column+1);
		}

		@Override
		public void setValueAt(Object aValue, int row, int column) {
			 foodDB.setData(row+1, column+1,(String)aValue);
		}

		@Override
		public boolean isCellEditable(int row, int column) {
			return column>0;
		}

		@Override
		public void removeRow(int row) {
			foodDB.delData(row+1);
		}

		@Override
		public void addRow(Object[] rowData) {
			foodDB.addData();
		}
		
		
	}

}