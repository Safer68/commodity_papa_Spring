package by.nenartovich.impl;

import by.nenartovich.dao.HorseRepository;
import by.nenartovich.HorseService;
import by.nenartovich.dto.HorseDto;
import by.nenartovich.entity.Horse;
import by.nenartovich.mappers.HorseMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class HorseServiceImpl implements HorseService {

    private final HorseRepository horseRepository;
    private final HorseMapper horseMapper;

    public HorseServiceImpl(HorseRepository horseRepository, HorseMapper horseMapper) {
        this.horseRepository = horseRepository;
        this.horseMapper = horseMapper;
    }

    @Override
    public List<HorseDto> findAll() {
        return StreamSupport
                .stream(horseRepository.findAll().spliterator(), false)
                .map(horseMapper::toHorseDto)
                .collect(Collectors.toList());
    }

    @Override
    public HorseDto findById(Long horseId) {
        Horse horse = horseRepository.findById(horseId).orElse(null);
        return horseMapper.toHorseDto(horse);
    }

    @Override
    public void save(HorseDto horseDto) {
        horseRepository.save(horseMapper.toHorse(horseDto));
    }

    @Override
    public void deleteById(Long horseId) {
        horseRepository.deleteById(horseId);
    }
}
