package Main.Controllers;

import Main.Logics.DTO;
import Main.Logics.ReadFilesFromFolder;
import Main.MyClass;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.util.List;

public class MainFormController {
    @FXML private TabPane tabPane;
    @FXML private Button btn_settings;
    @FXML private Button btn_exit;

    @FXML private Tab tab_Datapool;
    @FXML private ListView<String> ListViewMain;
    @FXML private CheckBox cbox_atDel;
    @FXML private CheckBox cbox_atWrite;
    @FXML private CheckBox cbox_at2Del;
    @FXML private CheckBox cbox_at2Write;
    @FXML private CheckBox cbox_at3Del;
    @FXML private CheckBox cbox_at3Write;
    @FXML private CheckBox cbox_at4Del;
    @FXML private CheckBox cbox_at4Write;
    @FXML private CheckBox cbox_satDel;
    @FXML private CheckBox cbox_satWrite;
    @FXML private Button btn_delAll;
    @FXML private Button btn_writeAll;
    @FXML private Button btn_clearAll;
    @FXML private Button btn_selectDir;
    @FXML private Button btn_selectFiles;
    @FXML private Button btn_clearList;
    @FXML private Button btn_delFromList;
    @FXML private Button btn_saveToDB;

    @FXML private Tab tab_Editing;


    private String projectDir = "c:\\work\\Proj_Omsk-Spb_GIT\\TEST\\testdata\\";


    @FXML
    void initialize() throws Exception {
        initData();


        btn_delAll.setOnAction(event -> {
            cbox_atDel.setSelected(true);
            cbox_at2Del.setSelected(true);
            cbox_at3Del.setSelected(true);
            cbox_at4Del.setSelected(true);
            cbox_satDel.setSelected(true);
        });


        btn_writeAll.setOnAction(event -> {
            cbox_atWrite.setSelected(true);
            cbox_at2Write.setSelected(true);
            cbox_at3Write.setSelected(true);
            cbox_at4Write.setSelected(true);
            cbox_satWrite.setSelected(true);
        });


        btn_clearAll.setOnAction(event -> {
            cbox_atDel.setSelected(false);
            cbox_at2Del.setSelected(false);
            cbox_at3Del.setSelected(false);
            cbox_at4Del.setSelected(false);
            cbox_satDel.setSelected(false);

            cbox_atWrite.setSelected(false);
            cbox_at2Write.setSelected(false);
            cbox_at3Write.setSelected(false);
            cbox_at4Write.setSelected(false);
            cbox_satWrite.setSelected(false);
        });


        btn_selectDir.setOnAction(event -> {
            final DirectoryChooser directoryChooser = new DirectoryChooser();
            directoryChooser.setTitle("Выберите папку с датапулами и нажмите \"Выбор папки\"");
            if (new File(projectDir).exists()) {
                directoryChooser.setInitialDirectory(new File(projectDir));
            }

            File dir = directoryChooser.showDialog(MyClass.getStage());
            if (dir != null) {
                String path = dir.getAbsolutePath();

                ReadFilesFromFolder.getFilesForFolder(path);
                DTO.shot_full_HashMapNames.forEach((k, v) -> DTO.dpNames_ObserveList.add(k));
                ListViewMain.setItems(DTO.dpNames_ObserveList);
            }
        });


        btn_selectFiles.setOnAction(event -> {
            FileChooser fileChooser = new FileChooser();
            FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Excell files", "*.xls", "*.xlsx");
            fileChooser.getExtensionFilters().add(extFilter);
            fileChooser.setTitle("Выберите один или несколько файлов");

            if (new File(projectDir).exists()) {
                fileChooser.setInitialDirectory(new File(projectDir));
            }

            List<File> files = fileChooser.showOpenMultipleDialog(MyClass.getStage()); // showSaveDialog(null); - если null, то окно не будет модальным
            if (files != null) {
                if (files.size() > 0) {
                    ReadFilesFromFolder.processSelectedFiles(files);
                }
            }

            DTO.shot_full_HashMapNames.forEach((k, v) -> DTO.dpNames_ObserveList.add(k));
            ListViewMain.setItems(DTO.dpNames_ObserveList);
        });


        btn_clearList.setOnAction(event -> {
            ListViewMain.getItems().remove(0, ListViewMain.getItems().size());
        });


        btn_delFromList.setOnAction(event -> {
            ObservableList<String> selectedItems = ListViewMain.getSelectionModel().getSelectedItems();
            ListViewMain.getItems().removeAll(selectedItems);
        });


        ListViewMain.setOnMouseClicked(click -> {
            if (click.getClickCount() == 1) getSelModel(ListViewMain);
            if (click.getClickCount() == 2) {
                btn_delFromList.fire();
                ListViewMain.getSelectionModel().clearSelection();
            }
        });


        btn_saveToDB.setOnAction(event -> {

        });


        btn_exit.setOnAction(event -> {
            Stage stage = (Stage) btn_exit.getScene().getWindow();
            stage.close();
        });


        btn_settings.setOnAction(event -> {

        });


    }


    private void initData() {}

    public static ObservableList<String> getSelModel(ListView<String> listView) {
        MultipleSelectionModel<String> listSelectionModel = listView.getSelectionModel();
        listSelectionModel.setSelectionMode(SelectionMode.MULTIPLE);
        return listSelectionModel.getSelectedItems();
    }

    /*
 SELECT * from ATEST_DATASTORE where DATAPOOL = 'dp777_12345';
 INSERT INTO ATEST_DATASTORE (DATAPOOL, DPNAME, DPVALUE, GLOBALVAR) VALUES ('dp777_12345', 'name1', 'value1', '');
 DELETE FROM ATEST_DATASTORE WHERE DATAPOOL = 'dp777_12345';


 gitlab.com ruvdos hellet118






 */



}

