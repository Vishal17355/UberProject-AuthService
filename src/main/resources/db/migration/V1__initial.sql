CREATE TABLE IF NOT EXISTS booking
(
    id             BIGINT AUTO_INCREMENT NOT NULL,
    created_at     datetime NOT NULL,
    updatedat      datetime NOT NULL,
    review_id      BIGINT NULL,
    booking_status ENUM( 'INITIATED','COMPLETED','CANCELLED','SCHEDULED') NULL,
    starttime      datetime NULL,
    endtime        datetime NULL,
    total_dist     BIGINT   NOT NULL,
    driver_id      BIGINT NULL,
    passenger_id   BIGINT NULL,
    CONSTRAINT pk_booking PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS booking_review
(
    id         BIGINT AUTO_INCREMENT NOT NULL,
    created_at datetime     NOT NULL,
    updatedat  datetime     NOT NULL,
    content    VARCHAR(255) NOT NULL,
    rating DOUBLE NOT NULL,
    CONSTRAINT pk_bookingreview PRIMARY KEY (id)
);

CREATE TABLE driver
(
    id             BIGINT AUTO_INCREMENT NOT NULL,
    created_at     datetime     NOT NULL,
    updatedat      datetime     NOT NULL,
    name           VARCHAR(255) NULL,
    license_number VARCHAR(255) NOT NULL,
    CONSTRAINT pk_driver PRIMARY KEY (id)
);

CREATE TABLE passenger
(
    id         BIGINT AUTO_INCREMENT NOT NULL,
    created_at datetime NOT NULL,
    updatedat  datetime NOT NULL,
    name       VARCHAR(255) NULL,
    CONSTRAINT pk_passenger PRIMARY KEY (id)
);

CREATE TABLE passenger_review
(
    id                     BIGINT NOT NULL,
    pasengerreview_comment VARCHAR(255) NULL,
    passenger_rating       VARCHAR(255) NULL,
    CONSTRAINT pk_passengerreview PRIMARY KEY (id)
);

ALTER TABLE driver
    ADD CONSTRAINT uc_driver_licensenumber UNIQUE (license_number);

ALTER TABLE booking
    ADD CONSTRAINT FK_BOOKING_ON_DRIVER FOREIGN KEY (driver_id) REFERENCES driver (id);

ALTER TABLE booking
    ADD CONSTRAINT FK_BOOKING_ON_PASSENGER FOREIGN KEY (passenger_id) REFERENCES passenger (id);

ALTER TABLE booking
    ADD CONSTRAINT FK_BOOKING_ON_REVIEW FOREIGN KEY (review_id) REFERENCES booking_review (id);

ALTER TABLE passenger_review
    ADD CONSTRAINT FK_PASSENGERREVIEW_ON_ID FOREIGN KEY (id) REFERENCES booking_review (id);