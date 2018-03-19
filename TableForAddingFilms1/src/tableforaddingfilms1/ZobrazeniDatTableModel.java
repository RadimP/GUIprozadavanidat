/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tableforaddingfilms1;

import java.util.ArrayList;
import java.util.Vector;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author RadimP
 */
public class ZobrazeniDatTableModel extends AbstractTableModel  {

    Vector<Object> col; //column names from database
    Vector<Vector<Object>> data; //vector to populate table with data from database 
DataFromDatabase datafromdtb = new DataFromDatabase();
    ZobrazeniDatTableModel() {
         col = datafromdtb.getColumnNamesFromSQLDatabase();
         data = datafromdtb.getDataFromSQLDatabase();
    }

    @Override
    public int getRowCount() {
        return data.size(); 
    }

    @Override
    public int getColumnCount() {
        return col.size(); 
    }

    @Override
    public Object getValueAt(int i, int i1) {
        return data.get(i).get(i1);
    }
 @Override
    public String getColumnName(int column) {
    return this.col.get(column).toString();
}
    @Override
    public Class getColumnClass(int column) {
                for (int row = 0; row < getRowCount(); row++) {
                    Object o = getValueAt(row, column);

                    if (o != null) {
                        return o.getClass();
                    }
                }

                return Object.class;
            }

    

}
