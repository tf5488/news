<%@page import="org.apache.commons.fileupload.FileUploadBase"%>
<%@page import="org.apache.commons.fileupload.FileUpload"%>
<%@page import="java.io.File"%>
<%@page import="org.apache.commons.fileupload.disk.DiskFileItemFactory"%>
<%@page import="org.apache.commons.fileupload.FileItemFactory"%>
<%@page import="org.apache.commons.fileupload.FileItem"%>
<%@page import="org.apache.commons.fileupload.servlet.ServletFileUpload"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	// 判断传入请求内容是否是multipart类型
	request.setCharacterEncoding("utf-8");
	boolean canupdata = ServletFileUpload.isMultipartContent(request);
	FileItemFactory fif = new DiskFileItemFactory();
	ServletFileUpload upload = new ServletFileUpload(fif);
	if (canupdata) {
		//out.print("上传!");
		//out.print(list.size());
		//ServletFileUpload uplod = new ServletFileUpload();
		upload.setFileSizeMax(1024 * 800);
		try {
			List<FileItem> list = upload.parseRequest(request); // 获取request传过来的列表项
			for (FileItem file : list) {
				if (file.isFormField()) { //判断是否是普通的表单
					String filename = file.getName();// 获得该表单项的 name值
					String filevalue = file.getString("UTF-8"); //  获得该表单项的value值
					out.print(filevalue);
				} else {
					String filename = file.getName(); // 获得该表单项的 文件名字
					//filename=new String(filename.getBytes("ISO-8859-1"),"UTF-8");
					//out.print(filename);
					String path1 = request.getSession()
							.getServletContext().getRealPath("/uplod");
					out.print(path1);
					List<String> enctype = Arrays.asList("jpg", "png",
							"bmp");
					String suffix = filename
							.substring(filename.indexOf(".") + 1)
							.trim().toLowerCase();
					if (enctype.contains(suffix)) {
						if (filename != null && !filename.equals("")) {
							//File fullfile = new File(filename);
							//String name = fullfile.getName();  目的是为了兼容低版本的浏览器
							File savefile = new File(path1, filename);
							file.write(savefile);
							//String name = fullfile.getName();
							out.print(filename);
						}
					} else {
						out.print("文件格式不正确,无法上传!支持格式为:jpg,png,bmp");
					}
				}
			}
		} catch (FileUploadBase.FileSizeLimitExceededException e) {
			out.print("文件太大了,不能超过800KB!");
		}
	} else {
	
		out.print("格式不正确,不能上传!");
	}
%>


