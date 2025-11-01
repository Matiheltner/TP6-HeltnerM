package resol.HeltnerM.controller;

import resol.HeltnerM.dao.ProductoDAO;
import resol.HeltnerM.dao.jdbc.JdbcProductoDAO;
import resol.HeltnerM.dto.ProductoDTO;

import java.util.List;

public class ProductoController {
    private final ProductoDAO dao = new JdbcProductoDAO();

    public void listarDisponibles() {
        try {
            List<ProductoDTO> lista = dao.findDisponibles();
            if (lista == null || lista.isEmpty())
                System.out.println("(sin productos disponibles)");
            else lista.forEach(System.out::println);
        } catch (Exception e) { e.printStackTrace(); }
    }

    public void listarReposicion() {
        try {
            List<ProductoDTO> lista = dao.findNecesitanReposicion();
            if (lista == null || lista.isEmpty())
                System.out.println("(sin productos para reponer)");
            else lista.forEach(System.out::println);
        } catch (Exception e) { e.printStackTrace(); }
    }
}