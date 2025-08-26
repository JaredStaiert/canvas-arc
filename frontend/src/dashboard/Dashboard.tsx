import { Flex, Text, Badge, Button, Card, Group, Image } from "@mantine/core";
import { useQuery } from "@tanstack/react-query";
import { getWorlds }from "@/api/world_api";

function Dashboard() {

    const query = useQuery({ queryKey: ["all-worlds"], queryFn: getWorlds });

    if (query.isLoading) {
      return <div>Loading...</div>;
    }

    return (
        <>
            <Flex
                direction="row"
                justify="flex-start"
                gap="xl"
            >
                <Flex
                    mih={50}
                    gap="sm"
                    justify="center"
                    align="center"
                    direction="row"
                    wrap="wrap"
                >
                    {query.data?.map((world) => (
                        <Card
                            shadow="sm"
                            padding="lg"
                            radius="md"
                            withBorder
                            key={`${world.worldName}_dashboard`}
                            // mih="25em"
                            miw="25em"
                        >
                            <Card.Section>
                                <Image
                                    src="https://raw.githubusercontent.com/mantinedev/mantine/master/.demo/images/bg-8.png"
                                    height={160}
                                    alt="Norway"
                                />
                            </Card.Section>
                            <Group justify="space-between" mt="md" mb="xs">
                                <Text fw={500}>{world.worldName}</Text>
                                <Badge color="orange">GM</Badge>
                            </Group>

                            <Text size="sm" c="dimmed">
                                {world.worldDesc}
                            </Text>

                            <Button color="blue" fullWidth mt="md" radius="md">
                                View {world.worldName}
                            </Button>
                        </Card>
                    ))}
                </Flex>
            </Flex>
        </>
    );
}

export default Dashboard;