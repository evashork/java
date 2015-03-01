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
		
		// 파일업로드
		
		String realFolder = ""; //파일이 실제로 업로드 될 서버 상의 물리적인 경로
		String saveFolder = "/"; //파일이 업로드될 폴더명 - 상대경로
		String encType = "UTF-8"; // 인코딩 속성
		int maxSize = 5 * 1024 * 1024; //
		
		ServletContext context = request.getServletContext();
		realFolder = context.getRealPath(saveFolder);
		//파라미터 값으로 지정된 상대 경로의 서버 상의 물리적인 경로를 얻어옴.
		
		MultipartRequest multi = new MultipartRequest(request,realFolder,maxSize,encType,new DefaultFileRenamePolicy());
		
		Dog dog = new Dog();
		// request 대신에 multi로 가져와야 한다.
		dog.setContent(multi.getParameter("content")); 
		dog.setCountry(multi.getParameter("country"));
		dog.setHeight(Integer.parseInt(multi.getParameter("height")));
		dog.setWeight(Integer.parseInt(multi.getParameter("weight")));
		dog.setPrice(Integer.parseInt(multi.getParameter("price")));
		dog.setImage(multi.getFilesystemName("image"));
		dog.setKind(multi.getParameter("kind"));
		
		DogRegistService dogRegistService = new DogRegistService();
		
		//등록 성공여부
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
			out.println("alert(등록실패);");
			out.println("history.back();");
			out.println("</script>");
		}
		return forward;
	}

}
