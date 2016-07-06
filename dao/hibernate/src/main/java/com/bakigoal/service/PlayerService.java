package com.bakigoal.service;

import com.bakigoal.dao.entity.Player;

import java.util.List;

/**
 * Created by ilmir on 27.06.16.
 */
public interface PlayerService {
	List<Player> getAll();

	Player getPlayerById(Long id);

	Player addPlayer(Player player);

	void updatePlayer(Player player);

	void deletePlayer(Long id);
}
