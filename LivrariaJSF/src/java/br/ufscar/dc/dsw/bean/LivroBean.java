package br.ufscar.dc.dsw.bean;

import br.ufscar.dc.dsw.dao.LivroDAO;
import br.ufscar.dc.dsw.pojo.Livro;
import java.sql.SQLException;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class LivroBean {

    private Livro livro;

    public String lista() {
        return "livro/index.xhtml";
    }

    public String cadastra() {
        livro = new Livro();
        return "form.xhtml";
    }

    public String edita(Long id) {
        LivroDAO dao = new LivroDAO();
        livro = dao.get(id);
        return "form.xhtml";
    }

    public String salva() {
        LivroDAO dao = new LivroDAO();
        if (livro.getId() == null) {
            dao.save(livro);
        } else {
            dao.update(livro);
        }
        return "index.xhtml";
    }

    public String delete(Livro livro) {
        LivroDAO dao = new LivroDAO();
        dao.delete(livro);
        return "index.xhtml";
    }

    public String volta() {
        return "/index.xhtml?faces-redirect=true";
    }

    public List<Livro> getLivros() throws SQLException {
        LivroDAO dao = new LivroDAO();
        return dao.getAll();
    }

    public Livro getLivro() {
        return livro;
    }
}