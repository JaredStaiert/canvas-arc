import React from 'react';
import { UnstyledButton, Group, Avatar, Text } from '@mantine/core';
import { IconChevronRight } from '@tabler/icons-react';

export interface UserButtonProps extends React.ComponentPropsWithoutRef<'button'> {
    image?: string;
    name?: string;
    email?: string;
    icon?: React.ReactNode;
}

export const UserButton: React.FC<UserButtonProps> = ({
                                                          image,
                                                          name,
                                                          email,
                                                          icon,
                                                          ...others
                                                      }) => (
    <UnstyledButton
        style={{
            padding: 'var(--mantine-spacing-md)',
            color: 'var(--mantine-color-text)',
            borderRadius: 'var(--mantine-radius-sm)',
        }}
        {...others}
    >
        <Group>
            <Avatar src={image} radius="xl" />

            <div style={{ flex: 1 }}>
                <Text size="sm" fw={500}>
                    {name}
                </Text>

                <Text c="dimmed" size="xs">
                    {email}
                </Text>
            </div>

            {icon || <IconChevronRight size={16} />}
        </Group>
    </UnstyledButton>
);