package resol.HeltnerM.controller;

import resol.HeltnerM.dao.ClienteDAO;
import resol.HeltnerM.dao.jdbc.JdbcClienteDAO;
import resol.HeltnerM.dto.ClienteDTO;

public class ClienteController {
    private final ClienteDAO dao = new JdbcClienteDAO();

    public void listar() {
        try { dao.findAll().forEach(System.out::println); }
        catch (Exception e) { e.printStackTrace(); }
    }
    public void agregar(String id, String nombre, String empresa) {
        try {
            ClienteDTO c = new ClienteDTO();
            c.setIdCliente(id);
            c.setNombreCompleto(nombre);
            c.setNombreEmpresa(empresa);
            dao.insert(c);
            System.out.println("Insert cliente OK.");
        } catch (Exception e) { e.printStackTrace(); }
    }
    public void actualizar(String id, String nombre, String empresa) {
        try { System.out.println("Update rows = " + dao.update(id, new ClienteDTO(){{
            setNombreCompleto(nombre); setNombreEmpresa(empresa);
        }})); } catch (Exception e) { e.printStackTrace(); }
    }
    public void eliminar(String id) {
        try { System.out.println("Delete rows = " + dao.delete(id)); }
        catch (Exception e) { e.printStackTrace(); }
    }
}