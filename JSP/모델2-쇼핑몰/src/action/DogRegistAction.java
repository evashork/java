package action;

import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.DogRegistService;
import vo.ActionForward;
import vo.Dog;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class DogRegistAction implements Action {

	@Override
	public ActionForward execute(HttpServletResponse response,
			HttpServletRequest request) throws Exception {
		
		// ���Ͼ��ε�
		
		String realFolder = ""; //������ ������ ���ε� �� ���� ���� �������� ���
		String saveFolder = "/"; //������ ���ε�� ������ - �����
		String encType = "UTF-8"; // ���ڵ� �Ӽ�
		int maxSize = 5 * 1024 * 1024; //
		
		ServletContext context = request.getServletContext();
		realFolder = context.getRealPath(saveFolder);
		//�Ķ���� ������ ������ ��� ����� ���� ���� �������� ��θ� ����.
		
		MultipartRequest multi = new MultipartRequest(request,realFolder,maxSize,encType,new DefaultFileRenamePolicy());
		
		Dog dog = new Dog();
		// request ��ſ� multi�� �����;� �Ѵ�.
		dog.setContent(multi.getParameter("content")); 
		dog.setCountry(multi.getParameter("country"));
		dog.setHeight(Integer.parseInt(multi.getParameter("height")));
		dog.setWeight(Integer.parseInt(multi.getParameter("weight")));
		dog.setPrice(Integer.parseInt(multi.getParameter("price")));
		dog.setImage(multi.getFilesystemName("image"));
		dog.setKind(multi.getParameter("kind"));
		
		DogRegistService dogRegistService = new DogRegistService();
		
		//��� ��������
		boolean isResistSuccess = dogRegistService.registDog(dog);
		
		ActionForward forward = null;
		if(isResistSuccess){
			forward = new ActionForward();
			forward.setUrl("dogList.dog");
			forward.setRedirect(true);
		}else{
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			
			out.println("<script>");
			out.println("alert(��Ͻ���);");
			out.println("history.back();");
			out.println("</script>");
		}
		return forward;
	}

}
