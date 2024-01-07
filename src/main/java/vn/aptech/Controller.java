package vn.aptech;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.aptech.dao.BookDao;
import vn.aptech.dao.CategoryDao;
import vn.aptech.entity.Book;
import vn.aptech.entity.Category;

/**
 * Servlet implementation class Controller
 */
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	BookDao bDao = new BookDao();
	CategoryDao cDao = new CategoryDao();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Controller() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// request.getServletPath()
		String a = request.getParameter("a");
		log("a: " + a);
		if (a == null) {
			// truyền category => filter
			request.setAttribute("categories", cDao.findAll());
			request.setAttribute("books", bDao.findAll());
			request.getRequestDispatcher("book/index.jsp").forward(request, response);
		} else {
			switch (a) {
			case "BookFilter": {
				String category = request.getParameter("category");
				int cateId = Integer.parseInt(category);
				log("Category: " + cateId);
				List<Book> result = null;
				if (cateId == 0) {
					result = bDao.findAll();
				} else {
					Category cate = cDao.findById(cateId);
					result = cate.getBooks();
				}

				request.setAttribute("categories", cDao.findAll());
				request.setAttribute("books", result);
				request.getRequestDispatcher("book/index.jsp").forward(request, response);
				break;
			}
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
