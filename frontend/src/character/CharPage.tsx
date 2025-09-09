import { JSX, useState } from 'react';
import { Flex, Paper, Tabs } from '@mantine/core';
import { CharacterDTO } from "@/api/character_api";

interface CharPageProps {
    character: CharacterDTO;
}

function CharPage({ character }: CharPageProps): JSX.Element {
  const [activeTab, setActiveTab] = useState<string | null>('biography');

  return (
    <>
      <Flex justify="flex-start">
        <Tabs
          radius="xs"
          orientation="vertical"
          defaultValue="gallery"
          value={activeTab}
          onChange={setActiveTab}
        >
          <Tabs.List>
            <Tabs.Tab value="biography">Biography</Tabs.Tab>
            <Tabs.Tab value="events">Events</Tabs.Tab>
            <Tabs.Tab value="settings">Settings</Tabs.Tab>
          </Tabs.List>

          <Tabs.Panel value="biography">
            <CharPageBio />
          </Tabs.Panel>

          <Tabs.Panel value="events">
            <CharPageEvents />
          </Tabs.Panel>

          <Tabs.Panel value="settings">Settings tab content</Tabs.Panel>
        </Tabs>
      </Flex>
    </>
  );
}

function CharPageBio() {
  return (
    <>
      <Flex
        justify="flex-start"
        p="md"
        align="flex-start"
        direction="column"
      >
        <Paper
          shadow="sm"
          p="sm"
        >
          <p>Basic Information</p>
        </Paper>
        <Paper
          shadow="sm"
          p="sm"
        >
          <p>Detailed bio</p>
        </Paper>
      </Flex>
    </>
  );
}

function CharPageEvents() {
  return (
    <>
      <p>Events the Character has taken part in.</p>
    </>
  );
}

export default CharPage;
