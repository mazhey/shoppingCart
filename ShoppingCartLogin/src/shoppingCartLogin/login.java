package shoppingCartLogin;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Lineitem;
import model.Shoppinguser;

/**
 * Servlet implementation class login
 */
@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public login() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		if (action.equals("login"))
			processRequest(request,response);
		else if (action.equals("signUp"))
			processSignup(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
		
	}
	
	protected void processSignup(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");	
		String name = request.getParameter("name");
		

		if (UserDB.usernameExists(username)){
			//add the record count to a session
			String message = "Username Exists.";
			HttpSession session = request.getSession();
			session.setAttribute("message", message);
			getServletContext()
			.getRequestDispatcher("/SignUp.jsp")
			.forward(request, response);
		}else {
			Shoppinguser myUser = new Shoppinguser();
			
			myUser.setFullname(name);
			myUser.setUsername(username);
			myUser.setPassword(password);
			try{
				UserDB.insert(myUser);
			}catch (Exception e){
				System.out.println("The insert did not work");
			}
			UserJB userBean = new UserJB();
			Shoppinguser temp = UserDB.selectUserID(myUser.getUsername());
			userBean.setUserId(temp.getUserId());
			userBean.setFullname(temp.getFullname());
		
			userBean.setUsername(temp.getUsername());
			System.out.println("userBean: ");
			System.out.println(userBean.getUsername());
			
			System.out.println(userBean.getFullname());
			//add the record count to a session
			HttpSession session = request.getSession();
			session.setAttribute("userProfile", userBean);
			session.setAttribute("myUser", userBean);
			boolean loginFlag = true;
			session.setAttribute("loginFlag", loginFlag);
			getServletContext()
			.getRequestDispatcher("/UserProfile.jsp")
			.forward(request, response);
		}
	}
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");	
		UserJB myUser = new UserJB();
		List<Lineitem> LineitemList = null;

		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		String qString = "Select u from User u where u.username = :username and u.password = :password ";
		TypedQuery<Shoppinguser> u = em.createQuery(qString, Shoppinguser.class);
		u.setParameter("username", username);
		u.setParameter("password", password);
		List<Shoppinguser> users;
		try{
			users = u.getResultList();
			if(users == null || users.isEmpty())
				users = null;
			else 
			{
				
				myUser.setFullname(users.get(0).getFullname());
				myUser.setUsername(users.get(0).getUsername());
				myUser.setUserId(users.get(0).getUserId());
				LineitemList = users.get(0).getLineitems();
			}
		}finally{
			em.close();  
		}
		//add the record count to a session
		HttpSession session = request.getSession();
		session.setAttribute("myUser", myUser);
		request.setAttribute("userProfile", myUser);
		request.setAttribute("tweetsList", tweetsList);
		boolean loginFlag = true;
		session.setAttribute("loginFlag", loginFlag);
		getServletContext()
		.getRequestDispatcher("/UserProfile.jsp")
		.forward(request, response);
	}


}
