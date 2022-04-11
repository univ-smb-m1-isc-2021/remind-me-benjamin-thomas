package me.guillaume.chuck_facts.infrastructure.persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Date;

@Service
class Initializer {

    private final ChuckFactsRepository repository;
    private final UsersRepository repositoryUsers;
    private final NotificationRepository repositoryNotification;
    private final NotificationChannelsRepository repositoryChannel;

    @Autowired
    UsersRepository usersService;

    @Autowired
    NotificationRepository notificationService;

    @Autowired
    NotificationChannelsRepository channelService;

    public Initializer(ChuckFactsRepository repository, UsersRepository repositoryUsers, NotificationRepository repositoryNotification, NotificationChannelsRepository repositoryChannel) {
        this.repository = repository;
        this.repositoryUsers = repositoryUsers;
        this.repositoryNotification = repositoryNotification;
        this.repositoryChannel = repositoryChannel;
    }

    @PostConstruct
    public void initialize() {

        repository.deleteAllInBatch();
        repositoryUsers.deleteAllInBatch();
        repositoryNotification.deleteAllInBatch();
        repositoryChannel.deleteAllInBatch();

        if (repository.findAll().isEmpty()) {
            repository.saveAndFlush(new ChuckFact("Chuck Norris can divide by zero."));
            repository.saveAndFlush(new ChuckFact("Chuck Norris once lost his wedding ring....since then it's been war in Middle Earth"));
            repository.saveAndFlush(new ChuckFact("In the Beginning there was nothing ... then Chuck Norris roundhouse kicked nothing and told it to get a job"));
            repository.saveAndFlush(new ChuckFact("When God said, “Let there be light!” Chuck said, “Say Please.”"));
        }

        if(repositoryNotification.findAll().isEmpty()) {
            repositoryNotification.saveAndFlush(new Notification("Wash the flopp", "wash the flopp with soap", new Date(), true, 0));
            repositoryNotification.saveAndFlush(new Notification("Feed the flopp", "feed the flopp with cement", new Date(), true, 0));
            repositoryNotification.saveAndFlush(new Notification("Pet the flopp", "pet the flopp with your hands (careful, he's aggressive)", new Date(), true, 0));
        }

        if (repositoryChannel.findAll().isEmpty()){
            repositoryChannel.saveAndFlush(new NotificationChannels("floppa mail", "mail", "tyazze@gmail.com"));
            repositoryChannel.saveAndFlush(new NotificationChannels("secondary floppa mail", "mail", "thomas0bellon@gmail.com"));
            repositoryChannel.saveAndFlush(new NotificationChannels("third floppa mail", "mail", "other@nakashita.fr"));
        }

        if(repositoryUsers.findAll().isEmpty()) {
            repositoryUsers.saveAndFlush(new Users("John Doe", "motDePasse", "tyazze@gmail.com"));
            repositoryUsers.saveAndFlush(new Users("Jane Doe", "motDePasse", "jane@caramail.fr"));
            repositoryUsers.saveAndFlush(new Users("Floppa", "nuclearFLOPP", "thomas0bellon@gmail.com"));

            Users tmp = usersService.findByName("Floppa");
            tmp.setNotifications(notificationService.findAll());
            tmp.setNotificationChannels(channelService.findAll());
            usersService.saveAndFlush(tmp);
        }
    }

}
