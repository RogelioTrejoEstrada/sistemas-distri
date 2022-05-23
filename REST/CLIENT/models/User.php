<?php

namespace models;

use GuzzleHttp\Client;
use config\Keys;

class User
{
    /**
     * 
     */
    public static function getAll()
    {
        $client = new Client([
            'base_uri' => Keys::getKey('API_HOST'),
            'timeout'  => 2.0,
        ]);
        $response = $client->get('/api/users/');
        $users = json_decode($response->getBody()->getContents());
        return $users->users;
    }
}
