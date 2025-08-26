import { Menu } from "@mantine/core";
import React, { useState } from "react";
import { useAuth } from "@/login/AuthProvider";
import { UserButton } from "./UserButton";

function AppHeaderMenu() {
    const { logout, user } = useAuth();
    const [opened, setOpened] = useState(false);

    return (
        <>
            <Menu
                opened={opened}
                onChange={setOpened}
            >
                <Menu.Target>
                    <UserButton
                        image=""
                        name={user?.userName}
                        email={user?.email}
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