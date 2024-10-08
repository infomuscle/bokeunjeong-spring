insert into introduction (introduction_id, title, description, display)
values
            ('I001', 'Development-Oriented', 'Started to learn programming to be a IT service planner. Kept on coding several hours every day after school for one year. Thought work could be enjoyable if became a developer, and became a developer.', true)
          , ('I002', 'Simple, Structured Code Writer', 'Think good speaker delivers deep thought with easy expressions. Want to be a person who make efficient program with short codes. Reading books like Clean Code, and continuing to improve codes I wrote.',  true)
          , ('I003', 'Being Wide, To Be Deep', 'Created business documents every week working as PM in a social business project. Produced visuals with Photoshop and Illustrator. Made me a developer writing wiki and drawing diagrams in well-communicative way.',  true)
          , ('I004', 'Like Achivements from Steady Endeavor', 'Regard talent, luck, effort as the most important factors to be successful. Concentrate on effort which is the only factor I can control. Progressed Github daily contributions for 398 days, and completed two side projects.',  true)
          , ('I005', 'Launched Mobile Game, Nyantarctic Adventure', 'Think good finish is as important as good start. Experienced whole cycle of service in this side project. Developed a casual mobile game using free times for six months, and launched it on App Store and Google Play.',  true)
;

insert into skill_proficiency (skill_proficiency_id, level, detail)
values
            ('SP1', 1, 'Have experience of use in development')
          , ('SP2', 2, 'Can use without difficulty')
          , ('SP3', 3, 'Learning in deep to use with core understand as a main skill')
;

insert into
            skill (skill_id, name, type, category, image, skill_proficiency_id, display)
values
            ('S001', 'Java', 'LANGUAGE', 'WORK', 'assets/img/logos/java.svg', 'SP3', true)
          , ('S002', 'Python', 'LANGUAGE', 'WORK', 'assets/img/logos/python.svg', 'SP2', true)
          , ('S003', 'Kotlin', 'LANGUAGE', 'PERSONAL', 'assets/img/logos/kotlin.svg', 'SP2', true)
          , ('S004', 'JavaScript', 'LANGUAGE', 'WORK', 'assets/img/logos/javascript.svg', 'SP1', true)
          , ('S005', 'Spring', 'FRAMEWORK', 'WORK', 'assets/img/logos/spring.svg', 'SP3', true)
          , ('S006', 'Django', 'FRAMEWORK', 'PERSONAL', 'assets/img/logos/django.svg', 'SP1', true)
          , ('S007', 'Vue.js', 'FRAMEWORK', 'PERSONAL', 'assets/img/logos/vue.svg', 'SP1', true)
          , ('S008', 'Oracle', 'DATABASE', 'WORK', 'assets/img/logos/oracle.svg', 'SP2', true)
          , ('S009', 'PostgreSQL', 'DATABASE', 'WORK', 'assets/img/logos/postgresql.svg', 'SP2', true)
          , ('S010', 'MySQL', 'DATABASE', 'PERSONAL', 'assets/img/logos/mysql.svg', 'SP1', true)
          , ('S011', 'Git', 'TOOL', 'WORK', 'assets/img/logos/git.svg', 'SP3', true)
          , ('S012', 'JPA', 'FRAMEWORK', 'WORK', 'assets/img/logos/jpa.svg', 'SP3', true)
          , ('S013', 'RabbitMQ', 'FRAMEWORK', 'WORK', 'assets/img/logos/rabbitmq.svg', 'SP2', true)
          , ('S014', 'Kafka', 'FRAMEWORK', 'WORK', 'assets/img/logos/kafka.svg', 'SP2', true)
          , ('S015', 'Docker', 'TOOL', 'PERSONAL', 'assets/img/logos/docker.svg', 'SP1', true)
          , ('S016', 'GCP', 'TOOL', 'PERSONAL', 'assets/img/logos/kubernetes.svg', 'SP1', true)
          , ('S017', 'Unity', 'FRAMEWORK', 'PERSONAL', 'assets/img/logos/unity.svg', 'SP2', true)
          , ('S018', 'C#', 'LANGUAGE', 'PERSONAL', 'assets/img/logos/csharp.svg', 'SP2', true)
          , ('S019', 'AWS', 'TOOL', 'PERSONAL', 'assets/img/logos/aws.svg', 'SP1', true)
          , ('S020', 'Grafana', 'TOOL', 'WORK', 'assets/img/logos/grafana.svg', 'SP1', true)
          , ('S021', 'InfluxDB', 'DATABASE', 'WORK', 'assets/img/logos/influxdb.svg', 'SP1', true)
;

insert into project (project_id, name, type, description, client, start_year, start_month, end_year, end_month, image, display)
values
            ('P001', 'SSG Easy-Payment Module', 'WORK', 'Applied Easy-Payment Module to Order and Delivery Page', null, 2019, 7, 2019, 8, null, false)
          , ('P002', 'Ssgpaycon API Integration', 'WORK', 'API Integration of Ssgpaycon Coupon Products', null, 2019, 8, 2019, 10, null, false)
          , ('P003', 'Emart Online Store', 'WORK', 'Developed Order Validation API for Emart Automation Center', null, 2019, 12, 2019, 12, null, false)
          , ('P004', 'Mobile Gift Order MSA Project', 'WORK', 'Newly Developed Mobile Gift MSA Project', null, 2020, 3, 2020, 8, null, true)
          , ('P005', 'Mobile Gift Claim MSA Project', 'WORK', 'Added Claim Features to Reduce Heavy CS Burden caused by Order-Only Service', null, 2021, 6, 2022, 2, null, true)
          , ('P006', 'bokeunjeong', 'PERSONAL', 'Personal Website aimed at Learning New skills and Technical Practice', null, 2020, 9, 2020, 11, null, true)
          , ('P007', 'Nyantarctic Adventure ', 'PERSONAL', 'Casual Mobile Game Project', null, 2021, 1, 2021, 6, null, true)
          , ('P008', 'Affiliate Admin Service API Project Building', 'WORK', 'Separated Service Layer from Obsolescent Legacy Back Office System', null, 2021, 12, 2022, 2, null, false)
          , ('P009', 'e-Coupon Service Improvement', 'WORK', 'Improvement for operational efficiency and service stabilization', null, 2022, 3, 2022, 12, null, false)
          , ('P010', 'Affiliate Team Operation Admin System', 'WORK', 'Developed Team-Only Operation Admin System to Resolve Increased Team Demand', null, 2022, 7, 2022, 7, null, true)
          , ('P011', 'Mobile Gift Data Validation System', 'WORK', 'Developed Monitoring System for Data Inconsistency of Issued Coupon by Getting Up-to-date Status, Checking Order and Affiliate DB', null, 2022, 8, 2022, 9, null, true)
          , ('P012', 'Freebie Mobile Gift Send Reservation Service', 'WORK', 'Automated sending freebie mobile gift improving order API enabling send reservation', null, 2022, 10, 2022, 12, null, true)
;

insert into project_detail (project_detail_id, project_id, detail, display_sequence, type)
values
            ('PD0001', 'P001', 'Applied easy-payment module to changing reserved payment method service of funding products', 1, 'DESCRIPTION')
          , ('PD0002', 'P001', 'Developed registering cards and displaying registred cards service in easy-payment', 2, 'DESCRIPTION')
          , ('PD0003', 'P002', 'Developed claim APIs for cancel, resend, status, usage', 1, 'DESCRIPTION')
          , ('PD0004', 'P002', 'Developed admin pages for test and operation', 2, 'DESCRIPTION')
          , ('PD0005', 'P003', 'Developed order validation API', 1, 'DESCRIPTION')
          , ('PD0006', 'P004', 'Designed tables - Analyzed 15 diffierent API guides of affiliated companies and enabled to manage orders, order items, transactions of coupons', 1, 'DESCRIPTION')
          , ('PD0007', 'P004', 'Factory pattern - Improved structure from former if-else statement to call service beans of each affiliated companies', 2, 'DESCRIPTION')
          , ('PD0008', 'P004', 'Transaction - Set order-completed when payment have done, updated to delivery-completed or order-canceld depending on transaction result', 3, 'DESCRIPTION')
          , ('PD0009', 'P005', 'Developed APIs - Improved order feature and newly developed features of cancel, resend, status', 1, 'DESCRIPTION')
          , ('PD0010', 'P005', 'Designed REST APIs - declared resource accessing level using order and message id and enabled flexible react to various process unit like orders and coupons', 2, 'DESCRIPTION')
          , ('PD0011', 'P005', 'Applied AOP - Separated cross-cutting-concerns such as saving interface data, sending monitoring data, from main business logic ', 3, 'DESCRIPTION')
          , ('PD0012', 'P005', 'Applied TDD - Wrote integreation test codes testing exceeding request limits, status insconsistency, duplicated requests and some unit tests', 4, 'DESCRIPTION')
          , ('PD0013', 'P005', 'Migrated DB - Migrated older data from main Oracle DB to new postgreSQL DB, enabled claim features to older orders', 5, 'DESCRIPTION')
          , ('PD0014', 'P004', 'Monitoring - Visualized transaction result, spent time, net spent time, etc by timeline and affiliated companies', 4, 'DESCRIPTION')
          , ('PD0015', 'P006', 'Developed with Java, Spring, MySQL', 1, 'DESCRIPTION')
          , ('PD0016', 'P006', 'Deployed Docker image on AWS EC2', 2, 'DESCRIPTION')
          , ('PD0017', 'P006', 'Practiced ORM with Spring Data JPA', 3, 'DESCRIPTION')
          , ('PD0018', 'P006', 'Tested Java and Spring features for learning', 4, 'DESCRIPTION')
          , ('PD0019', 'P006', 'Built CI/CD pipeline with Github Actions', 5, 'DESCRIPTION')
          , ('PD0020', 'P007', 'Developed with Unity', 1, 'DESCRIPTION')
          , ('PD0021', 'P007', 'API Integration for Google Admob, AppLovin MAX, GameAnalytics', 2, 'DESCRIPTION')
          , ('PD0022', 'P007', 'User data analysis in partnership with Lion Studios', 3, 'DESCRIPTION')
          , ('PD0023', 'P007', 'Launched on App Store and Google Play', 4, 'DESCRIPTION')
          , ('PD0024', 'P008', 'Suggested architecure separating service logics from monolithic back office', 1, 'DESCRIPTION')
          , ('PD0025', 'P008', 'Designed common paging structure for data selection APIs', 2, 'DESCRIPTION')
          , ('PD0026', 'P008', 'Developed APIs for responsible services such as order-list, coupon-use', 3, 'DESCRIPTION')
          , ('PD0027', 'P009', 'Developed batch to check unlinked order data', 1, 'DESCRIPTION')
          , ('PD0028', 'P009', 'Developed back-office system to retry/cancel unlinked order', 2, 'DESCRIPTION')
          , ('PD0029', 'P009', 'Developed back-office system to block illegal users', 3, 'DESCRIPTION')
          , ('PD0030', 'P009', 'Applied Sentry to catch exceptions in detail', 4, 'DESCRIPTION')
          , ('PD0031', 'P010', 'Implemented simple login feature - Based on company LDAP and JWT', 1, 'DESCRIPTION')
          , ('PD0032', 'P010', 'Implemented Thymeleaf templates based on Bootstrap - Modularized commonly used features like sidebar, table, input form by separating as fragment', 2, 'DESCRIPTION')
          , ('PD0033', 'P010', 'Minimized handling front modules - Designed structure handling sidebar menu, grid columns, search conditions from interceptor and controllers', 3, 'DESCRIPTION')
          , ('PD0035', 'P011', 'Developed validation target list API - Query validation target list in descending order of last synchronized date time', 1, 'DESCRIPTION')
          , ('PD0036', 'P011', 'Developed validation API - Get up-to-date coupon data from issuers, compare status with Order DB, post-processing, send notifications for error cases by coupon unit', 2, 'DESCRIPTION')
          , ('PD0037', 'P011', 'Developed validation processing batch - Get validation target list and pulbish each coupon to RabbitMQ', 3, 'DESCRIPTION')
          , ('PD0038', 'P011', 'Developled consumer - Call validation API with consumed coupon data', 4, 'DESCRIPTION')
          , ('PD0039', 'P006', 'https://github.com/infomuscle/bokeunjeong-spring', 6, 'LINK')
          , ('PD0040', 'P007', 'https://apps.apple.com/us/app/nyantarctic-adventure/id1567917739', 5, 'LINK')
          , ('PD0041', 'P007', 'https://play.google.com/store/apps/details?id=com.rabbitcatstudios.nyantarctica', 6, 'LINK')
          , ('PD0042', 'P012', 'Upgraded order API - withold order data with reservation information', 1, 'DESCRIPTION')
          , ('PD0043', 'P012', 'Developed send-reservation target list API - Query reservation coupon list by send date, status code, etc', 2, 'DESCRIPTION')
          , ('PD0044', 'P012', 'Developed send-reservation process API - Validate reservation and send coupon', 3, 'DESCRIPTION')
          , ('PD0045', 'P012', 'Developed send-reservation process Batch - Call send-reservation target list API and publish each coupon to RabbitMQ', 4, 'DESCRIPTION')
          , ('PD0046', 'P012', 'Developed consumer - Call send-reservation process API', 5, 'DESCRIPTION')
          , ('PD0047', 'P012', 'Developed monitoring batch - Query missed or failed reservations after processing batch', 6, 'DESCRIPTION')
;

insert into link (link_id, title, url, display)
values
            ('L001', 'Github', 'https://github.com/infomuscle', true)
          , ('L002', 'Blog', 'https://bortfolio.tistory.com/', true)
          , ('L003', 'Resume', 'https://bit.ly/336nmuY', true)
          , ('L004', 'Linkedin', 'https://bit.ly/2XT9PrI', true)
;

insert into contact (contact_id, type, detail, icon)
values
            ('C01', 'ADDRESS', 'Samhaksa Street, Songpa, Seoul, KR', 'fa-map-marked-alt')
          , ('C02', 'EMAIL', 'infomuscle10@gmail.com', 'fa-envelope')
          , ('C03', 'PHONE', 'Please Contact via Email', 'fa-mobile-alt')
;
