package br.ufscar.dc.dsw.bean;

import br.ufscar.dc.dsw.dao.EditoraDAO;
import br.ufscar.dc.dsw.pojo.Editora;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class EditoraBean implements Serializable {

    private Editora editora;

    public String lista() {
        return "editora/index.xhtml";
    }

    public String cadastra() {
        editora = new Editora();
        return "form.xhtml";
    }

    public String edita(Long id) {
        EditoraDAO dao = new EditoraDAO();
        editora = dao.get(id);
        return "form.xhtml";
    }

    public String salva() {
        EditoraDAO dao = new EditoraDAO();
        if (editora.getId() == null) {
            dao.save(editora);
        } else {
            dao.update(editora);
        }
        return "index.xhtml";
    }

    public String delete(Editora editora) {
        EditoraDAO dao = new EditoraDAO();
        dao.delete(editora);
        return "index.xhtml";
    }

    public String volta() {
        return "/index.xhtml?faces-redirect=true";
    }
    
    public List<Editora> getEditoras() throws SQLException {
        EditoraDAO dao = new EditoraDAO();
        return dao.getAll();
    }

    public Editora getEditora() {
        return editora;
    }
}