package br.ufscar.dc.dsw.converter;

import br.ufscar.dc.dsw.dao.EditoraDAO;
import br.ufscar.dc.dsw.pojo.Editora;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter("EditoraConverter")
public class EditoraConverter implements Converter{

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        Long id = Long.parseLong(string);
        EditoraDAO dao = new EditoraDAO();
        return dao.get(id);
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
        Editora editora = (Editora) o;
        return editora.getId().toString();
    }
}