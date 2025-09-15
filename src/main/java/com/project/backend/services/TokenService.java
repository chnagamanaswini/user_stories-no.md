package com.project.backend.services;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class TokenService {
    // Store tokens mapped to user IDs (simple in-memory implementation)
    private Map<Integer, String> tokenStore = new HashMap<>();

    // Generate a token for a user
    public String generateToken(int userId) {
        String token = UUID.randomUUID().toString();
        tokenStore.put(userId, token);
        return token;
    }

    // Validate a token
    public boolean validateToken(int userId, String token) {
        return tokenStore.containsKey(userId) && tokenStore.get(userId).equals(token);
    }

    // Invalidate a token (logout)
    public boolean invalidateToken(int userId) {
        if (tokenStore.containsKey(userId)) {
            tokenStore.remove(userId);
            return true;
        }
        return false;
    }
}
