import java.util.ArrayList;
import java.util.List;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class Window {
	
	@FXML
	private ListView<String> leftt;
	@FXML
	private ListView<String> rightt;
	@FXML
	private TextField entert;
	@FXML
	private Button enterb;
	@FXML
	private Button leftb;
	@FXML
	private Button rightb;
	
	private List<String> datal;
	private List<String> datar;
	
	private ListProperty<String> datapropertyl;
	private ListProperty<String> datapropertyr;
	
	@FXML
	private void enterAction() {
		String text = entert.getText();
		datapropertyl.add(text);		
	}
	
	@FXML 
	private void rightAction() {
		if (datapropertyl.getSize() > 0) {
			datapropertyr.add(datapropertyl.get(datapropertyl.getSize()-1));
			datapropertyl.remove(datapropertyl.getSize()-1);
		}
	}
	
	@FXML
	private void leftAction() {
		if (datapropertyr.getSize() > 0) {
			datapropertyl.add(datapropertyr.get(datapropertyr.getSize()-1));
			datapropertyr.remove(datapropertyr.getSize()-1);
		}
	}
	 
	@FXML
	private void initialize() {		
		datal = new ArrayList<String>();
		datar = new ArrayList<String>();
		datapropertyl = new SimpleListProperty<>();
		datapropertyr = new SimpleListProperty<>();
		
		leftt.itemsProperty().bind(datapropertyl);
		rightt.itemsProperty().bind(datapropertyr);
		
		datapropertyl.set(FXCollections.observableArrayList(datal));
		datapropertyr.set(FXCollections.observableArrayList(datar));		
		
	}	
}




