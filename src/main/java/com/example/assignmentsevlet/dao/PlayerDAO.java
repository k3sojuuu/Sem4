package com.example.assignmentsevlet.dao;

import com.example.assignmentsevlet.database.Database;
import com.example.assignmentsevlet.entity.Player;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PlayerDAO {

    private Connection conn;


    public PlayerDAO() {
            this.conn = Database.getInstance().getConnection();
    }

    public boolean addPlayer(Player player) {

        String sql = "INSERT INTO player (name, full_name, age, index_id) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, player.getName());
            stmt.setString(2, player.getFullName());
            stmt.setString(3, player.getAge());
            stmt.setLong(4, player.getIndexId());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Lấy tất cả người chơi
    public List<Player> getAllPlayers() {
        List<Player> players = new ArrayList<>();
        String sql = "SELECT * FROM player";
        try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Player player = new Player();
                player.setPlayerId(rs.getLong("player_id"));
                player.setName(rs.getString("name"));
                player.setFullName(rs.getString("full_name"));
                player.setAge(rs.getString("age"));
                player.setIndexId(rs.getLong("index_id"));
                players.add(player);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return players;
    }

    // Lấy người chơi theo ID
    public Player getPlayerById(long playerId) {
        Player player = null;
        String sql = "SELECT * FROM player WHERE player_id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setLong(1, playerId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                player = new Player();
                player.setPlayerId(rs.getLong("player_id"));
                player.setName(rs.getString("name"));
                player.setFullName(rs.getString("full_name"));
                player.setAge(rs.getString("age"));
                player.setIndexId(rs.getLong("index_id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return player;
    }

    // Cập nhật thông tin người chơi
    public boolean updatePlayer(Player player) {
        String sql = "UPDATE player SET name = ?, full_name = ?, age = ?, index_id = ? WHERE player_id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, player.getName());
            stmt.setString(2, player.getFullName());
            stmt.setString(3, player.getAge());
            stmt.setLong(4, player.getIndexId());
            stmt.setLong(5, player.getPlayerId());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Xóa người chơi
    public boolean deletePlayer(long playerId) {
        String sql = "DELETE FROM player WHERE player_id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setLong(1, playerId);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}