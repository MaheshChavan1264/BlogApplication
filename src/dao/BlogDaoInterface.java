package dao;

import java.sql.SQLException;
import java.util.List;

import model.Blog;

public interface BlogDaoInterface {
	void insertBLog(Blog blog) throws SQLException;
	Blog selectBlog(int blogId);
	List<Blog> selectAllBlogs();
	boolean deleteBLog(int id) throws SQLException;
	boolean updateBlog(Blog blog) throws SQLException, Exception;
}
