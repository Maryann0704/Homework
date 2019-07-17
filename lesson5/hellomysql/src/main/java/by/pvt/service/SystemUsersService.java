package by.pvt.service;

import by.pvt.dao.SystemUsersMapper;
import by.pvt.dto.SystemUsers;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.*;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SystemUsersService {

    private static Logger log = Logger.getLogger(SystemUsersService.class.getName());

    private SqlSessionFactory sqlSessionFactory;

    SystemUsersService() {
        try {
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(
                    Resources.getResourceAsStream("by/pvt/service/mybatis-config.xml")
            );
        } catch (IOException e) {
            log.log(Level.SEVERE, e.getMessage(), e);
        }
    }

    public List<SystemUsers> getSystemUsers() {
        return sqlSessionFactory
                .openSession()
                .getMapper(SystemUsersMapper.class)
                .selectByExample(null);
    }

    public void insertSystemUser(SystemUsers systemUser){
        SqlSession session = sqlSessionFactory.openSession();
        session.getMapper(SystemUsersMapper.class).insert(systemUser);
        session.commit();
        session.close();
    }

    public void updateSystemUser(SystemUsers systemUser) {
        SqlSession session = sqlSessionFactory.openSession();
        session.getMapper(SystemUsersMapper.class).updateByPrimaryKey(systemUser);
        session.commit();
        session.close();
    }

    public void deleteSystemUser(int id) {
        SqlSession session = sqlSessionFactory.openSession();
        session.getMapper(SystemUsersMapper.class).deleteByPrimaryKey(id);
        session.commit();
        session.close();
    }
}