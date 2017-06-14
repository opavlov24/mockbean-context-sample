## Description

This is a sample project to demonstrate the issue with spring context and MockBean annotation.
If we use MockBean with SpringBootTest (integration tests) then spring context is reloaded for each test class, without it, everything is OK,
the context is cached.