Student: Zane Labonte-Hagar, 101239002

## Steps
Open the project in IntelliJ IDEA and run `com.github.konicai.Sysc4806LabApplication` using an IntelliJ IDEA run configuration.

## Example invocation

```
  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/

 :: Spring Boot ::                (v4.1.1)

2026-10-01T00:17:06.787-04:00  INFO 24120 --- [sysc4806-lab3] [           main] c.github.konicai.Sysc4806LabApplication  : Starting Sysc4806LabApplication using Java 21.0.6 with PID 24120 (C:\Users\zlabo\Documents\classes\sysc4806\lab3\target\classes started by zlabo in C:\Users\zlabo\Documents\classes\sysc4806\lab3)
2026-10-01T00:17:06.792-04:00  INFO 24120 --- [sysc4806-lab3] [           main] c.github.konicai.Sysc4806LabApplication  : No active profile set, falling back to 1 default profile: "default"
2026-10-01T00:17:07.271-04:00  INFO 24120 --- [sysc4806-lab3] [           main] .s.d.r.c.RepositoryConfigurationDelegate : Bootstrapping Spring Data JPA repositories in DEFAULT mode.
2026-10-01T00:17:07.326-04:00  INFO 24120 --- [sysc4806-lab3] [           main] .s.d.r.c.RepositoryConfigurationDelegate : Finished Spring Data repository scanning in 45 ms. Found 2 JPA repository interfaces.
2026-10-01T00:17:07.714-04:00  INFO 24120 --- [sysc4806-lab3] [           main] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Starting...
2026-10-01T00:17:07.911-04:00  INFO 24120 --- [sysc4806-lab3] [           main] com.zaxxer.hikari.pool.HikariPool        : HikariPool-1 - Added connection conn0: url=jdbc:h2:mem:a5c1706f-6ecb-4b1f-9138-aca8dcfad53a user=SA
2026-10-01T00:17:07.913-04:00  INFO 24120 --- [sysc4806-lab3] [           main] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Start completed.
2026-10-01T00:17:07.958-04:00  INFO 24120 --- [sysc4806-lab3] [           main] org.hibernate.orm.jpa                    : HHH008540: Processing PersistenceUnitInfo [name: default]
2026-10-01T00:17:08.025-04:00  INFO 24120 --- [sysc4806-lab3] [           main] org.hibernate.orm.core                   : HHH000001: Hibernate ORM core version 7.4.5.Final
2026-10-01T00:17:08.566-04:00  INFO 24120 --- [sysc4806-lab3] [           main] o.s.o.j.p.SpringPersistenceUnitInfo      : No LoadTimeWeaver setup: ignoring JPA class transformer
2026-10-01T00:17:08.673-04:00  INFO 24120 --- [sysc4806-lab3] [           main] org.hibernate.orm.connections.pooling    : HHH10001005: Database info:
	Database JDBC URL [jdbc:h2:mem:a5c1706f-6ecb-4b1f-9138-aca8dcfad53a]
	Database driver: H2 JDBC Driver
	Database dialect: H2Dialect
	Database version: 2.5.250
	Default catalog/schema: A5C1706F-6ECB-4B1F-9138-ACA8DCFAD53A/PUBLIC
	Autocommit mode: undefined/unknown
	Isolation level: READ_COMMITTED [default READ_COMMITTED]
	JDBC fetch size: 100
	Pool: DataSourceConnectionProvider
	Minimum pool size: undefined/unknown
	Maximum pool size: undefined/unknown
2026-10-01T00:17:09.777-04:00  INFO 24120 --- [sysc4806-lab3] [           main] org.hibernate.orm.core                   : HHH000489: No JTA platform available (set 'hibernate.transaction.jta.platform' to enable JTA platform integration)
2026-10-01T00:17:09.836-04:00  INFO 24120 --- [sysc4806-lab3] [           main] j.LocalContainerEntityManagerFactoryBean : Initialized JPA EntityManagerFactory for persistence unit 'default'
2026-10-01T00:17:09.920-04:00  INFO 24120 --- [sysc4806-lab3] [           main] o.s.d.j.r.query.QueryEnhancerFactories   : Hibernate is in classpath; If applicable, HQL parser will be used.
2026-10-01T00:17:10.220-04:00  INFO 24120 --- [sysc4806-lab3] [           main] c.github.konicai.Sysc4806LabApplication  : Started Sysc4806LabApplication in 3.895 seconds (process running for 4.641)
2026-10-01T00:17:10.274-04:00  INFO 24120 --- [sysc4806-lab3] [           main] c.github.konicai.Sysc4806LabApplication  : BuddyInfo persistence test
2026-10-01T00:17:10.507-04:00  INFO 24120 --- [sysc4806-lab3] [           main] c.github.konicai.Sysc4806LabApplication  : All BuddyInfo:
2026-10-01T00:17:10.507-04:00  INFO 24120 --- [sysc4806-lab3] [           main] c.github.konicai.Sysc4806LabApplication  : Name: Zane, Phone Number: 1234
2026-10-01T00:17:10.507-04:00  INFO 24120 --- [sysc4806-lab3] [           main] c.github.konicai.Sysc4806LabApplication  : Name: Ben, Phone Number: 555-555-5555
2026-10-01T00:17:10.507-04:00  INFO 24120 --- [sysc4806-lab3] [           main] c.github.konicai.Sysc4806LabApplication  : 
2026-10-01T00:17:10.507-04:00  INFO 24120 --- [sysc4806-lab3] [           main] c.github.konicai.Sysc4806LabApplication  : AddressBook persistence test
2026-10-01T00:17:10.527-04:00  INFO 24120 --- [sysc4806-lab3] [           main] c.github.konicai.Sysc4806LabApplication  : All BuddyInfo:
2026-10-01T00:17:10.527-04:00  INFO 24120 --- [sysc4806-lab3] [           main] c.github.konicai.Sysc4806LabApplication  : Name: Zane, Phone Number: 1234
2026-10-01T00:17:10.527-04:00  INFO 24120 --- [sysc4806-lab3] [           main] c.github.konicai.Sysc4806LabApplication  : Name: Ben, Phone Number: 555-555-5555
2026-10-01T00:17:10.527-04:00  INFO 24120 --- [sysc4806-lab3] [           main] c.github.konicai.Sysc4806LabApplication  : Name: Bradley, Phone Number: 6789
2026-10-01T00:17:10.527-04:00  INFO 24120 --- [sysc4806-lab3] [           main] c.github.konicai.Sysc4806LabApplication  : 
2026-10-01T00:17:10.531-04:00  INFO 24120 --- [sysc4806-lab3] [           main] c.github.konicai.Sysc4806LabApplication  : All AddressBook:
2026-10-01T00:17:10.532-04:00  INFO 24120 --- [sysc4806-lab3] [           main] c.github.konicai.Sysc4806LabApplication  : AddressBook:
Name: Zane, Phone Number: 1234
Name: Ben, Phone Number: 555-555-5555
Name: Bradley, Phone Number: 6789
2026-10-01T00:17:10.532-04:00  INFO 24120 --- [sysc4806-lab3] [           main] c.github.konicai.Sysc4806LabApplication  : 
2026-10-01T00:17:10.541-04:00  INFO 24120 --- [sysc4806-lab3] [ionShutdownHook] j.LocalContainerEntityManagerFactoryBean : Closing JPA EntityManagerFactory for persistence unit 'default'
2026-10-01T00:17:10.547-04:00  INFO 24120 --- [sysc4806-lab3] [ionShutdownHook] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Shutdown initiated...
2026-10-01T00:17:10.549-04:00  INFO 24120 --- [sysc4806-lab3] [ionShutdownHook] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Shutdown completed.
```
