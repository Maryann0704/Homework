package by.pvt.service;

import by.pvt.dao.SystemUsersMapper;
import by.pvt.dto.SystemUsers;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.*;

import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;


public class SystemUsersService {

    private static Logger log = Logger.getLogger(SystemUsersService.class.getName());

    private SqlSessionFactory sqlSessionFactory;

    public SystemUsersService(boolean forTest) {
        if (forTest){
            try {
                sqlSessionFactory = new SqlSessionFactoryBuilder().build(
                        Resources.getResourceAsStream("by/pvt/service/mybatis-config-junit.xml")
                );
            } catch (IOException e) {
                log.log(Level.SEVERE, e.getMessage(), e);
            }
        }
        else {
            try {
                sqlSessionFactory = new SqlSessionFactoryBuilder().build(
                        Resources.getResourceAsStream("by/pvt/service/mybatis-config.xml")
                );
            } catch (IOException e) {
                log.log(Level.SEVERE, e.getMessage(), e);
            }
        }

    }

    public List<SystemUsers> getSystemUsers() {
        return sqlSessionFactory
                .openSession()
                .getMapper(SystemUsersMapper.class)
                .selectByExample(null);
    }

    void insertSystemUser(SystemUsers systemUser){
        SqlSession session = sqlSessionFactory.openSession(true);
        session.getMapper(SystemUsersMapper.class).insert(systemUser);
    }

    void addAll(List<SystemUsers> systemUsers) {
        if(systemUsers == null){
            log.info("The input systemUsers is null");
            return;
        }
        SqlSession session = sqlSessionFactory.openSession();
        if (session == null) {
            log.info("Session is null");
            return;
        }
        SystemUsersMapper mapper = session.getMapper(SystemUsersMapper.class);
        try {systemUsers.stream()
                .filter(Objects::nonNull)
                .forEach(mapper::insert);
            session.commit();
        } catch (Exception e) {
            log.log(Level.WARNING, e.getMessage(), e);
            session.rollback();
        } finally {
            session.close();
        }

        session.close();
    }

    int updateSystemUser(SystemUsers systemUser) {
       return sqlSessionFactory
                .openSession(true)
                .getMapper(SystemUsersMapper.class)
                .updateByPrimaryKey(systemUser);
    }

    void deleteSystemUser(int id) {
        SqlSession session = sqlSessionFactory.openSession(true);
        session.getMapper(SystemUsersMapper.class).deleteByPrimaryKey(id);
    }
}