INSERT INTO t_permission(name)
VALUES ('ROLE_USER')
    ON CONFLICT (name) DO NOTHING;
