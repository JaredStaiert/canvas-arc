import { Button, Menu } from "@mantine/core";
import React, { useState } from "react";
import { useAuth } from "@/login/AuthProvider";
import { UserButton } from "./UserButton";

function AppHeaderMenu() {
    const { logout } = useAuth();
    const [opened, setOpened] = useState(false);

    return (
        <>
            <Menu
                opened={opened}
                onChange={setOpened}
            >
                <Menu.Target>
                    <UserButton
                        image="https://raw.githubusercontent.com/mantinedev/mantine/master/.demo/avatars/avatar-8.png"
                        name="Harriette Spoonlicker"
                        email="hspoonlicker@outlook.com"
                    />
                </Menu.Target>
                <Menu.Dropdown>
                    <Menu.Label>Options</Menu.Label>
                    <Menu.Item>Settings</Menu.Item>
                    <Menu.Item>Export</Menu.Item>
                    <Menu.Item
                        color="red"
                        onClick={logout}
                    >
                        Logout
                    </Menu.Item>
                </Menu.Dropdown>
            </Menu>
        </>
    );
}

export default AppHeaderMenu;