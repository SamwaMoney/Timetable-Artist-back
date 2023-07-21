package SamwaMoney.TimeTableArtist.Class.service;

import SamwaMoney.TimeTableArtist.Class.domain.Class;
import SamwaMoney.TimeTableArtist.Class.domain.Weekday;
import SamwaMoney.TimeTableArtist.Class.dto.ClassRequestDto;
import SamwaMoney.TimeTableArtist.Class.repository.ClassRepository;
import SamwaMoney.TimeTableArtist.Timetable.domain.Timetable;
import SamwaMoney.TimeTableArtist.Timetable.repository.TimetableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClassService {

    private final ClassRepository classRepository;
    private final TimetableRepository timetableRepository;

    @Autowired
    public ClassService(ClassRepository classRepository, TimetableRepository timetableRepository) {
        this.classRepository = classRepository;
        this.timetableRepository = timetableRepository;
    }

    public void createClassSchedule(List<ClassRequestDto> classDTOs) {
        Timetable timetable = timetableRepository.findById(classDTOs.get(0).getTable())
                .orElseThrow(() -> new RuntimeException("Timetable not found"));

        List<Class> classes = new ArrayList<>();
        for (ClassRequestDto classDto : classDTOs) {
            //Weekday weekday = Weekday.valueOf(classDto.getWeekday().toString().toUpperCase());
            Weekday weekday = null;

            switch(classDto.getWeekday()){
                case "월" : weekday = Weekday.MON; break;
                case "화" : weekday = Weekday.TUE; break;
                case "수" : weekday = Weekday.WED; break;
                case "목" : weekday = Weekday.THU; break;
                case "금" : weekday = Weekday.FRI; break;
            }

            Class newClass = Class.builder()
                    .timetable(timetable)
                    .className(classDto.getClassName())
                    .location(classDto.getLocation())
                    .weekday(weekday)
                    .startH(classDto.getStartH())
                    .startM(classDto.getStartM())
                    .endH(classDto.getEndH())
                    .endM(classDto.getEndM())
                    .build();

            classes.add(newClass);
        }

        classRepository.saveAll(classes);
    }
}

