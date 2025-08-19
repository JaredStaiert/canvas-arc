import { Avatar, Group, Stack, Text } from "@mantine/core";
import React from "react";

function AppHeaderUserProfileButton() {
    return (
      <>
          <Group>
              <Avatar src={null} alt="no image here"/>
              <Stack gap="xs">
                  <Text size="xs">UserName</Text>
                  <Text size="xs">Email</Text>
              </Stack>
          </Group>
      </>
    );
}

export default AppHeaderUserProfileButton;