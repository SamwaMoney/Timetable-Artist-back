package SamwaMoney.TimeTableArtist.Class.controller;

        import SamwaMoney.TimeTableArtist.Class.dto.ClassRequestDto;
        import SamwaMoney.TimeTableArtist.Class.service.ClassService;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.http.HttpStatus;
        import org.springframework.http.ResponseEntity;
        import org.springframework.web.bind.annotation.PostMapping;
        import org.springframework.web.bind.annotation.RequestBody;
        import org.springframework.web.bind.annotation.RequestHeader;
        import org.springframework.web.bind.annotation.RequestMapping;
        import org.springframework.web.bind.annotation.RestController;

        import java.util.List;

@RestController
@RequestMapping("/classes")
public class ClassController {

    private final ClassService classService;

    @Autowired
    public ClassController(ClassService classService) {
        this.classService = classService;
    }

    @PostMapping
    public ResponseEntity<String> createClasses(
            //@RequestHeader("timetableId") Long timetableId,
            @RequestBody List<ClassRequestDto> classDTOs
    ) {
        classService.createClassSchedule(classDTOs);
        return new ResponseEntity<>("Classes created successfully", HttpStatus.CREATED);
    }
}
