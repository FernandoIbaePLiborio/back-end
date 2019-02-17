package br.com.bb.dto;

import java.util.List;

public abstract class AbstractDTO<T> {
	
	private boolean ok;
    private String  message;
    private List<T> list;

    public AbstractDTO() {
        super();
    }
    
    public AbstractDTO(List<T> pList) {
        super();
        list = pList;
    }

    public AbstractDTO(boolean pOk, String pMessage) {
        super();
        ok = pOk;
        message = pMessage;
    }
    
    public AbstractDTO(boolean pOk, List<T> pList) {
        super();
        ok = pOk;
        list = pList;
    }

    public AbstractDTO(boolean pOk, String pMessage, List<T> pList) {
        super();
        ok = pOk;
        message = pMessage;
        list = pList;
    }

    public boolean isOk() {
        return ok;
    }

    public void setOk(boolean pOk) {
        ok = pOk;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String pMessage) {
        message = pMessage;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> pList) {
        list = pList;
    }

}
