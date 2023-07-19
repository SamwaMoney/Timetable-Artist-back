package SamwaMoney.TimeTableArtist.Class.service;

import SamwaMoney.TimeTableArtist.Class.domain.Class;
import SamwaMoney.TimeTableArtist.Class.domain.Weekday;
import SamwaMoney.TimeTableArtist.Class.dto.ClassDto;
import SamwaMoney.TimeTableArtist.Class.dto.ClassDto;
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

    public void createClassSchedule(Long timetableId, List<ClassDto> classDTOs) {
        Timetable timetable = timetableRepository.findById(timetableId)
                .orElseThrow(() -> new RuntimeException("Timetable not found"));

        List<Class> classes = new ArrayList<>();
        for (ClassDto classDto : classDTOs) {
            Weekday weekday = Weekday.valueOf(classDto.getWeekday().toUpperCase());

            Class newClass = Class.builder()
                    .table(timetable)
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

