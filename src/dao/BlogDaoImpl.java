package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.sun.glass.ui.Robot;
import com.sun.xml.internal.bind.Locatable;

import model.Blog;
import utility.ConnectionManager;

public class BlogDaoImpl implements BlogDaoInterface {

	private static final String INSERT_BLOG_SQL = "insert into blog(blogid,blogtitle,blogdescription,postedon) values(seq_blog.nextval,?,?,?)";
	private static final String SELECT_ALL_BLOGS = "select * from blog";
	private static final String DELETE_BLOG_BY_ID = "delete from blog where blogid =?"; 
	@Override
	public void insertBLog(Blog blog) throws SQLException {
		System.out.println(INSERT_BLOG_SQL);
		try {
			Connection connection = ConnectionManager.getConnection();
			PreparedStatement statement = connection.prepareStatement(INSERT_BLOG_SQL);
			statement.setString(1, blog.getBlogTitle());
			System.out.println("blog title: "+blog.getBlogTitle());
			statement.setString(2, blog.getBlogDescription());
			statement.setDate(3, java.sql.Date.valueOf(blog.getPostedOn()));
			System.out.println(statement);
			statement.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Blog selectBlog(int blogId) {
		return null;
	}

	@Override
	public List<Blog> selectAllBlogs() {
		Blog blog = null;
		List<Blog> blogList = new ArrayList<>();
		
		try {
			Connection connection = ConnectionManager.getConnection();
			PreparedStatement statement = connection.prepareStatement(SELECT_ALL_BLOGS);
			System.out.println(statement);
			ResultSet resultSet = statement.executeQuery();
			while(resultSet.next()) {
				int blogId = resultSet.getInt("blogid");
				String blogTitle = resultSet.getString("blogtitle");
				System.out.println(blogTitle);
				String blogDescription = resultSet.getString("blogdescription");
				LocalDate postedOn = resultSet.getDate("postedon").toLocalDate();
				blog = new Blog();
				blog.setBlogId(blogId);
				blog.setBlogTitle(blogTitle);
				blog.setBlogDescription(blogDescription);
				blog.setPostedOn(postedOn);
				blogList.add(blog);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return blogList;
	}

	@Override
	public boolean deleteBLog(int id) throws SQLException {
		System.out.println(id);
		boolean rowDeleted = false;
		try{
			Connection connection = ConnectionManager.getConnection();
			PreparedStatement statement = connection.prepareStatement(DELETE_BLOG_BY_ID);
			statement.setInt(1, id);
			rowDeleted = statement.executeUpdate()>0;
		}catch (Exception e) {	
			e.printStackTrace();
		}
		return rowDeleted;
	}

	@Override
	public boolean updateBlog(Blog blog) throws SQLException, Exception {
		return false;
	}
	
}
