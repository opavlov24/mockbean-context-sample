## Description

This is a sample project to demonstrate the issue with spring context and MockBean annotation.
If we use MockBean with SpringBootTest (integration tests) then spring context is reloaded for each test class, without it, everything is OK,
the context is cached.

## How to run

Go to the project directory and run `./gradlew --rerun-tasks test -i` (or `./gradlew.bat ./gradlew --rerun-tasks test -i`) and you'll see the context is reloaded two times. If you remove @MockBean annotation from SecondElasticsearchRepositoryTest.dummyServiceToMock and run again, you'll see only one time.

## Example output

`017-06-14 14:03:15.850  INFO 29477 --- [       Thread-7] org.elasticsearch.node                   : [Dormammu] stopped
2017-06-14 14:03:15.850  INFO 29477 --- [       Thread-7] org.elasticsearch.node                   : [Dormammu] closing ...
2017-06-14 14:03:15.860  INFO 29477 --- [       Thread-7] org.elasticsearch.node                   : [Dormammu] closed
2017-06-14 14:03:15.897  INFO 29477 --- [       Thread-5] org.elasticsearch.node                   : [Punisher 2099] stopped
2017-06-14 14:03:15.898  INFO 29477 --- [       Thread-5] org.elasticsearch.node                   : [Punisher 2099] closing ...
2017-06-14 14:03:15.900  INFO 29477 --- [       Thread-5] org.elasticsearch.node                   : [Punisher 2099] closed`
