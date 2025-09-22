import { useQuery } from "@tanstack/react-query";
import { Link } from "react-router-dom";
import { Badge, Button, Card, Flex, Group, Image, Paper, Text } from "@mantine/core";
import { getWorlds } from "@/api/world_api";

function WorldDashboardPage() {
  const query = useQuery({ queryKey: ["all-worlds"], queryFn: getWorlds });

  return (
    <>
      <Flex mih={50} gap="xl" justify="center" align="center" direction="row" wrap="wrap">
        <Paper shadow="sm" radius="md" withBorder p="md">
          <Button color="green" radius="md" size="lg">
            New Setting
          </Button>
        </Paper>
        {query.data?.map((world) => (
          <Card
            shadow="sm"
            padding="lg"
            radius="md"
            withBorder
            key={world.worldName}
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

            <Link to={`/worlds/edit/${world.worldID}`} style={{ textDecoration: "none" }}>
              <Button color="blue" fullWidth mt="md" radius="md">
                View {world.worldName}
              </Button>
            </Link>
          </Card>
        ))}
      </Flex>
    </>
  );
}

export default WorldDashboardPage;
