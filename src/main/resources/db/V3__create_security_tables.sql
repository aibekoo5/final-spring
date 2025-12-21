CREATE TABLE t_permission (
                              id BIGSERIAL PRIMARY KEY,
                              name VARCHAR(255) NOT NULL UNIQUE
);

CREATE TABLE t_user (
                        id BIGSERIAL PRIMARY KEY,
                        username VARCHAR(255),
                        email VARCHAR(255) NOT NULL UNIQUE,
                        password VARCHAR(255) NOT NULL
);

CREATE TABLE t_user_permission (
                                   user_id BIGINT NOT NULL REFERENCES t_user (id) ON DELETE CASCADE,
                                   permission_id BIGINT NOT NULL REFERENCES t_permission (id) ON DELETE CASCADE,
                                   PRIMARY KEY (user_id, permission_id)
);
