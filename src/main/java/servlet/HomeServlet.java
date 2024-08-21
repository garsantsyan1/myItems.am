package servlet;

import manager.CategoryManager;
import manager.ItemManager;
import model.Category;
import model.Item;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet(urlPatterns = "/")
public class HomeServlet extends HttpServlet {

    private CategoryManager categoryManager = new CategoryManager();
    private ItemManager itemManager = new ItemManager();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Category> categories = categoryManager.getAllCategories();
        List<Item> items = itemManager.getAllItems();
        req.setAttribute("items", items);
        req.getRequestDispatcher("/WEB-INF/home.jsp").forward(req, resp);
    }
}
