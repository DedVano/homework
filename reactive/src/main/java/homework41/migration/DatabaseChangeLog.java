package homework41.migration;

import com.github.cloudyrock.mongock.ChangeLog;
import com.github.cloudyrock.mongock.ChangeSet;
import com.mongodb.client.MongoDatabase;
import homework41.model.Profession;
import homework41.repository.ProfessionMigrationRepository;

@ChangeLog
public class DatabaseChangeLog {

    @ChangeSet(order = "001", id = "dropDb", author = "Ivan Maltsev", runAlways = true)
    public void dropDb(MongoDatabase db) {
        db.drop();
    }

    @ChangeSet(order = "002", id = "insertNewProfessions", author = "Ivan Maltsev")
    public void insertProfessions(ProfessionMigrationRepository repository) {
        repository.save(new Profession(20040, "Агроном"));
        repository.save(new Profession(20101, "Артист балета"));
        repository.save(new Profession(20321, "Биолог"));
        repository.save(new Profession(20336, "Бухгалтер"));
        repository.save(new Profession(20448, "Врач"));
        repository.save(new Profession(20560, "Генеральный директор предприятия"));
        repository.save(new Profession(20580, "Генеральный секретарь"));
        repository.save(new Profession(20586, "Геодезист"));
        repository.save(new Profession(20743, "Главный дизайнер проекта"));
        repository.save(new Profession(21034, "Главный электрик"));
        repository.save(new Profession(21309, "Дилер"));
        repository.save(new Profession(21761, "Диспетчер связи"));
        repository.save(new Profession(21975, "Заведующий канцелярией"));
        repository.save(new Profession(22446, "Инженер"));
        repository.save(new Profession(22956, "Инспектор по кадрам"));
        repository.save(new Profession(23050, "Инструктор"));
        repository.save(new Profession(23324, "Капитан"));
        repository.save(new Profession(23739, "Лоцман"));
        repository.save(new Profession(25627, "Портье"));
    }
}


