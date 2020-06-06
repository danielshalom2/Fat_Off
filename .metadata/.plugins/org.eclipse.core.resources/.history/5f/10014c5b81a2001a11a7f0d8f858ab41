/**
 * 
 */
package com.FatOff.View;

import javax.swing.table.AbstractTableModel;

/**
 * @author borism
 *
 */
public class MenuTableModel extends AbstractTableModel{

	private final String[] columnNames;
	private final Class[] columnClass = new Class[] {String.class};
	private final int rows = 4;
	/**
	 * 
	 */
	
	public MenuTableModel(String[][] data, String[] colNames) {
		// TODO Auto-generated constructor stub
		this.columnNames = colNames;
	}

	@Override
	public String getColumnName(int column) {
		return columnNames[column];
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		return columnClass[columnIndex];
	}

	@Override
	public int getColumnCount() {
		return columnNames.length;
	}

	@Override
	public int getRowCount() {
		return rows;
	}

//	@Override
//	public Object getValueAt(int rowIndex, int columnIndex) {
//		Employee row = employeeList.get(rowIndex);
//		if (0 == columnIndex) {
//			return row.getId();
//		} else if (1 == columnIndex) {
//			return row.getName();
//		} else if (2 == columnIndex) {
//			return row.getHourlyRate();
//		} else if (3 == columnIndex) {
//			return row.isPartTime();
//		}
//		return null;
//	}
	
	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex)
	{
		if(columnIndex == 0)
	    	return false;
		else
			return true;
	}

@Override
public Object getValueAt(int rowIndex, int columnIndex) {
	// TODO Auto-generated method stub
	return null;
}

}
