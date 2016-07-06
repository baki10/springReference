package com.bakigoal.service.impl;

import com.bakigoal.dao.SimpleDao;
import com.bakigoal.dao.entity.Player;
import com.bakigoal.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

/**
 * Created by ilmir on 27.06.16.
 */
@Service
@Transactional
public class PlayerServiceImpl implements PlayerService {

  private SimpleDao playerDao;

  @Autowired
  public void setPlayerDao(SimpleDao playerDao) {
    this.playerDao = playerDao;
    playerDao.setEntityClass(Player.class);
  }

  @Override
  public List<Player> getAll() {
    return playerDao.getAll();
  }

  @Override
  public Player getPlayerById(Long id) {
    return id == null ? null : (Player) playerDao.findById(id);
  }

  @Override
  public Player addPlayer(Player player) {
    if (player == null) {
      return null;
    }
    Serializable id = playerDao.save(player);
    return id == null ? null : (Player) playerDao.findById(id);
  }

  @Override
  public void updatePlayer(Player player) {
    if (player == null) {
      return;
    }
    playerDao.update(player);
  }

  @Override
  public void deletePlayer(Long id) {
    if (id == null) {
      return;
    }
    Player player = (Player) playerDao.findById(id);
    if (player == null) {
      return;
    }
    playerDao.remove(player);
  }
}
