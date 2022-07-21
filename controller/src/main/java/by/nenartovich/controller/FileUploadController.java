package by.nenartovich.controller;
import by.nenartovich.utils.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author gaoxuyang
 * @ загрузка и отображение пользовательских изображений
 */
@Controller
public class FileUploadController {


    /*private final ResourceLoader resourceLoader;

    @Autowired
    public FileUploadController(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    @Value("${web.upload-path}")
    private String path;




    *//**
     * @return  Перейти на страницу загрузки файла
     *//*
    @RequestMapping("/Demo")
    public String index(){
        return "Dome";
    }
    *//**
     *
     * @return  Перейти на страницу отображения файла
     *//*
    @RequestMapping("/show")
    public String show(){
        return "show";
    }
    *//**
     *
     * @param  file загруженный файл
     * @return
     *//*
    @ResponseBody
    @RequestMapping("/fileUpload")
    public String upload(@RequestParam("file")MultipartFile file ){
        // 1 Определяем путь хранения файла для загрузки
        String localPath="D:/image";
        // 2 получаем имя файла
        String fileName=file.getOriginalFilename();
        // 2 ошибка загрузки
        String warning="";
        if(FileUtils.upload(file, localPath, fileName)){
            // Успешная загрузка
            warning="Загрузка успешно завершена";

        }else{
            warning="Загрузка не удалась";
        }
        System.out.println(warning);
        return "Загрузка успешно завершена";
    }

    *//**
     * Показать картинки
     * @param  fileName файла имя файла
     * @return
     *//*

    @RequestMapping("show")
    public ResponseEntity  show(String fileName){


        try {
            // Поскольку он предназначен для чтения локального файла, необходимо добавить файл, путь - это путь в файле конфигурации приложения
            return ResponseEntity.ok(resourceLoader.getResource("file:" + path + fileName));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }

    }*/
}

