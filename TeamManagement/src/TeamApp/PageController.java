package TeamApp;

import java.io.IOException;

import org.mybatis.domain.MemberDTO;

import static TeamApp.MainAppController.s_uid;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;


// 전체 레이아웃(index) 컨트롤러 클래스
public class PageController {
	
	// 전체 레이아웃 initialize (초기화)
	@FXML private Label TitleLabel;
	@FXML private Label TeamLabel;
	@FXML protected void initialize(){
		boolean state = false;
		// Topbar에 이름 띄우기
		MemberDAO dao = new MemberDAO();
		MemberDTO dto = null;
		dto = dao.checkUID(s_uid);
		TitleLabel.setText("안녕하세요, "+dto.getRealName()+"님!");
		
		// 시작페이지 결정
		int TID = dto.getLinkedTID();
		state = dao.isExistTID(TID); // user테이블의 LinkedTID를 가져와서, Tema테이블의 TID중 있는지 비교.
		if(state == false) {
			// 팀이 없을 경우 , 관리 페이지
		}else {
			// 팀이 있을 경우, 팀 정보 페이지
		} 
	}
	
	// 메인 페이지 --------------------------------------------------------------------------------
		// 사이드 메뉴 --------------------------------------------------------------------------------
		@FXML private AnchorPane viewPane;
		public void hMenuTeamButtonAction(MouseEvent event) throws IOException  {
			AnchorPane pane = FXMLLoader.load(getClass().getResource("/xml/Page_Team.fxml"));
			viewPane.getChildren().setAll(pane);
		}
		public void hMenuComButtonAction(MouseEvent event) throws IOException  {
			AnchorPane pane = FXMLLoader.load(getClass().getResource("/xml/Page_Com.fxml"));
			viewPane.getChildren().setAll(pane);
		}
		public void hMenuTodoButtonAction(MouseEvent event) throws IOException  {
			AnchorPane pane = FXMLLoader.load(getClass().getResource("/xml/Page_Todo.fxml"));
			viewPane.getChildren().setAll(pane);
		}
		public void hMenuSetButtonAction(MouseEvent event) throws IOException  {
			AnchorPane pane = FXMLLoader.load(getClass().getResource("/xml/Page_Set.fxml"));
			viewPane.getChildren().setAll(pane);
		}
}

