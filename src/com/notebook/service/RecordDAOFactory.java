package com.notebook.service;

/**
 * @author NikBor on 14.05.2016.
 */

import com.notebook.dao.RecordDAO;
import com.notebook.dao.RecordDAOImpl;

/**
 * Factory to create an instance RecordADO
 */
public class RecordDAOFactory {
    public static RecordDAO getContactDAO() {
        return new RecordDAOImpl();
    }
}
