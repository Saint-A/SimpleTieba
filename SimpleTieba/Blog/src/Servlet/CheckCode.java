package Servlet;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CheckCode extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public CheckCode() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("image/jpeg");
		HttpSession session=request.getSession();
		int width=60;
		int height=20;
		//�����������Ҫ�����ͼƬ
		response.setHeader("Pragma", "No-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
		//�����ڴ�ͼ�񲢻��ͼƬ������
		BufferedImage image =new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
		Graphics g=image.getGraphics();
		//�����������֤��
		//������֤����ַ���
		String chars="0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		char[] rands=new char[4];
		for(int i=0;i<4;i++)
		{
			int rand=(int)(Math.random()*36);
			rands[i]=chars.charAt(rand);
		}
		
		//����ͼ��
		//������
		g.setColor(new Color(0xDCDCDC));
		g.fillRect(0, 0, width, height);
		//�������120�����ŵ�
		for(int i=0;i<120;i++)
		{
			int x=(int)(Math.random()*width);
			int y=(int)(Math.random()*height);
			int red=(int)(Math.random()*255);
			int green=(int)(Math.random()*255);
			int blue=(int)(Math.random()*255);
			g.setColor(new Color(red,green,blue));
			g.drawOval(x, y, 1, 0);
		}
		
		g.setColor(Color.BLACK);
		g.setFont(new Font(null,Font.ITALIC|Font.BOLD,18));
		//�ڲ�ͬ�ĸ߶��������ͬ���ַ�
		g.drawString(""+rands[0], 1, 17);
		g.drawString(""+rands[1], 16, 15);
		g.drawString(""+rands[2], 31, 18);
		g.drawString(""+rands[3], 46, 16);
		g.dispose();
		//��ͼ��������ͻ���
		ServletOutputStream sos=response.getOutputStream();
		ByteArrayOutputStream baos=new ByteArrayOutputStream();
		ImageIO.write(image, "JPEG", baos);
		byte[] buffer=baos.toByteArray();
		response.setContentLength(buffer.length);
		sos.write(buffer);
		baos.close();
		sos.close();
		//����֤�����session��
		session.setAttribute("checkCode", new String(rands));
		
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}