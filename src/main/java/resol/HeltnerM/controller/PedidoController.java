package resol.HeltnerM.controller;

import resol.HeltnerM.dao.PedidoDAO;
import resol.HeltnerM.dao.jdbc.JdbcPedidoDAO;
import resol.HeltnerM.dto.PedidoDTO;

import java.time.LocalDate;

public class PedidoController {
    private final PedidoDAO dao = new JdbcPedidoDAO();

    public void listarPorCliente(String idCliente) {
        try { dao.findByCliente(idCliente).forEach(System.out::println); }
        catch (Exception e) { e.printStackTrace(); }
    }

    public void crearPedidoDemo() {
        try {
            PedidoDTO p = new PedidoDTO();
            p.setFechaPedido(LocalDate.now());
            p.setMontoTotal(null);
            int id = dao.insert(p);
            System.out.println("Insert pedido id = " + id);
        } catch (Exception e) { e.printStackTrace(); }
    }

    public void actualizarFechas(int id, boolean setEnvio, boolean setEntrega) {
        try {
            PedidoDTO p = new PedidoDTO();
            p.setIdPedido(id);
            if (setEnvio)   p.setFechaEnvio(LocalDate.now());
            if (setEntrega) p.setFechaEntrega(LocalDate.now());
            System.out.println("Update rows = " + dao.update(p));
        } catch (Exception e) { e.printStackTrace(); }
    }

    public void cambiarEstado(int id, String estado) {
        try { System.out.println("Cambio estado rows = " + dao.cambiarEstado(id, estado)); }
        catch (Exception e) { e.printStackTrace(); }
    }

    public void eliminar(int id) {
        try { System.out.println("Delete rows = " + dao.delete(id)); }
        catch (Exception e) { e.printStackTrace(); }
    }
}