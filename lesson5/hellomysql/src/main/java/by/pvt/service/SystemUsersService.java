package by.pvt.service;

import by.pvt.dao.SystemUsersMapper;
import by.pvt.dto.SystemUsers;
import by.pvt.dto.SystemUsersExample;
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
                        //Resources.getResourceAsStream("by/pvt/service/mybatis-config-junit.xml")
                        SystemUsersService.class.getResourceAsStream("mybatis-config-junit.xml")
                );
            } catch (Exception e) {
                log.log(Level.SEVERE, e.getMessage(), e);
            }
        }
        else {
            try {
                sqlSessionFactory = new SqlSessionFactoryBuilder().build(
                        SystemUsersService.class.getResourceAsStream("by/pvt/service/mybatis-config.xml")
                );
            } catch (IOException e) {
                log.log(Level.SEVERE, e.getMessage(), e);
            }
        }

    }

    protected void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    public List<SystemUsers> getSystemUsers() {
        return getSystemUsers(null);
    }

    public List<SystemUsers> getSystemUsers(SystemUsersExample example) {
        SqlSession session = sqlSessionFactory.openSession();
        SystemUsersMapper mapper = session.getMapper(SystemUsersMapper.class);

        List<SystemUsers> dtoUsers = mapper.selectByExample(example);

        session.close();
        return dtoUsers;
    }

    public void insertSystemUser(SystemUsers systemUser){
        SqlSession session = sqlSessionFactory.openSession(true);
        session.getMapper(SystemUsersMapper.class).insert(systemUser);
    }

    public void addAll(List<SystemUsers> systemUsers) {
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

    public int updateSystemUser(SystemUsers systemUser) {
       return sqlSessionFactory
                .openSession(true)
                .getMapper(SystemUsersMapper.class)
                .updateByPrimaryKey(systemUser);
    }

    public void deleteSystemUser(int id) {
        SqlSession session = sqlSessionFactory.openSession(true);
        session.getMapper(SystemUsersMapper.class).deleteByPrimaryKey(id);
    }
}